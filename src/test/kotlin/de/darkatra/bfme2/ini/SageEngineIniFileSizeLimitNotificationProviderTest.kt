package de.darkatra.bfme2.ini

import com.intellij.ide.util.PropertiesComponent
import com.intellij.openapi.fileEditor.FileEditorManager
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.testFramework.fixtures.LightPlatformCodeInsightFixture4TestCase
import com.intellij.ui.EditorNotificationPanel
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class SageEngineIniFileSizeLimitNotificationProviderTest : LightPlatformCodeInsightFixture4TestCase() {

    @Test
    fun `should explain how to resolve declarations of files that are too large for code insight`() {

        myFixture.addFileToProject("data/voice.ini", "AudioEvent NoVoice\nEnd\n".repeat(150_000))
        val file = myFixture.configureByText("commandset.ini", "CommandSet ElvenCommandSet\nEnd").virtualFile

        val panel = notification(file)

        assertThat(panel?.text)
            .contains("voice.ini")
            .contains("idea.max.intellisense.filesize")
            .contains("Help | Edit Custom Properties")
    }

    @Test
    fun `should not show a notification if all files are small enough`() {

        myFixture.addFileToProject("data/voice.ini", "AudioEvent NoVoice\nEnd\n")
        val file = myFixture.configureByText("commandset.ini", "CommandSet ElvenCommandSet\nEnd").virtualFile

        assertThat(notification(file)).isNull()
    }

    @Test
    fun `should not show the notification after it was dismissed`() {

        myFixture.addFileToProject("data/voice.ini", "AudioEvent NoVoice\nEnd\n".repeat(150_000))
        val file = myFixture.configureByText("commandset.ini", "CommandSet ElvenCommandSet\nEnd").virtualFile

        SageEngineIniFileSizeLimitNotificationProvider.dismiss(project)
        try {
            assertThat(notification(file)).isNull()
        } finally {
            // the light project is shared between tests
            PropertiesComponent.getInstance(project).unsetValue(SageEngineIniFileSizeLimitNotificationProvider.DISMISSED_KEY)
        }
    }

    private fun notification(file: VirtualFile): EditorNotificationPanel? {
        val fileEditor = FileEditorManager.getInstance(project).getSelectedEditor(file)!!
        return SageEngineIniFileSizeLimitNotificationProvider().collectNotificationData(project, file)?.apply(fileEditor) as EditorNotificationPanel?
    }
}
