package de.darkatra.bfme2.ini.settings

import com.intellij.openapi.fileChooser.FileChooser
import com.intellij.openapi.fileChooser.FileChooserDescriptorFactory
import com.intellij.openapi.options.ConfigurationException
import com.intellij.openapi.options.SearchableConfigurable
import com.intellij.openapi.project.Project
import com.intellij.openapi.util.io.FileUtil
import com.intellij.ui.CollectionListModel
import com.intellij.ui.ToolbarDecorator
import com.intellij.ui.components.JBList
import com.intellij.ui.dsl.builder.Align
import com.intellij.ui.dsl.builder.panel
import java.io.File
import javax.swing.JComponent

class SageEngineIniSettingsConfigurable(private val project: Project) : SearchableConfigurable {

    private val model = CollectionListModel<String>()

    override fun getId(): String = "de.darkatra.bfme2.ini.settings.SageEngineIniSettingsConfigurable"

    override fun getDisplayName(): String = "Sage Engine INI"

    override fun createComponent(): JComponent {
        val list = JBList(model)
        val decorator = ToolbarDecorator.createDecorator(list)
            .setAddAction { chooseDirectory() }
            .createPanel()

        return panel {
            row {
                comment(
                    "Additional directories (e.g. the base game ini files) that are indexed and used to resolve references and completions. " +
                        "Declarations of the project always win. If a declaration is present in multiple directories, the one " +
                        "listed first wins."
                )
            }
            row {
                cell(decorator).align(Align.FILL)
            }.resizableRow()
        }
    }

    override fun isModified(): Boolean {
        return model.items != SageEngineIniSettings.getInstance(project).additionalSourceDirectories
    }

    override fun apply() {
        val directories = model.items.map { FileUtil.toSystemIndependentName(it) }.distinct()
        directories.firstOrNull { !File(it).isDirectory }?.let {
            throw ConfigurationException("'$it' is not an existing directory.")
        }
        SageEngineIniSettings.getInstance(project).updateAdditionalSourceDirectories(directories)
    }

    override fun reset() {
        model.replaceAll(SageEngineIniSettings.getInstance(project).additionalSourceDirectories)
    }

    private fun chooseDirectory() {
        FileChooser.chooseFile(FileChooserDescriptorFactory.singleDir(), project, null) { directory ->
            if (directory.path !in model.items) {
                model.add(directory.path)
            }
        }
    }
}
