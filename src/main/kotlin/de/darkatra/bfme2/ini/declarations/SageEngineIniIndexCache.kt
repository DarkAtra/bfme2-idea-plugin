package de.darkatra.bfme2.ini.declarations

import com.intellij.openapi.project.Project
import com.intellij.openapi.util.Key
import com.intellij.openapi.util.ModificationTracker
import com.intellij.psi.util.CachedValue
import com.intellij.psi.util.CachedValueProvider
import com.intellij.psi.util.CachedValuesManager
import com.intellij.util.indexing.FileBasedIndex
import com.intellij.util.indexing.ID
import de.darkatra.bfme2.ini.settings.SageEngineIniSettings
import java.util.concurrent.ConcurrentHashMap

/**
 * Caches the results of lookups in an [index] until the index changes, so that inspections can look up every value of a file without
 * reading the index again for the names that repeat. Unlike a cache that depends on every change of a file, it survives typing and
 * switching files. The additional directories are part of the key because they change which declarations are found.
 */
internal class SageEngineIniIndexCache(private val index: ID<*, *>) {

    private val cacheKey = Key.create<CachedValue<ConcurrentHashMap<Any, Any>>>("sage.engine.ini.cache.${index.name}")

    fun <V : Any> get(project: Project, key: Any, compute: () -> V): V {
        val cache = CachedValuesManager.getManager(project).getCachedValue(project, cacheKey, {
            val indexChanges = ModificationTracker { FileBasedIndex.getInstance().getIndexModificationStamp(index, project) }
            CachedValueProvider.Result.create(ConcurrentHashMap<Any, Any>(), indexChanges)
        }, false)
        val directories = SageEngineIniSettings.getInstance(project).additionalSourceDirectories
        @Suppress("UNCHECKED_CAST")
        return cache.getOrPut(directories to key) { compute() } as V
    }
}
