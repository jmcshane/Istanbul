package com.mcshane.gradle.istanbul

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction
import org.gradle.sonar.runner.SonarRunnerExtension

class IstanbulTask extends DefaultTask {

	@TaskAction
	public void istanbul() {
		IstanbulExtension extension = 
			project.getExtensions().getByName(IstanbulExtension.ISTANBUL_EXTENSION_NAME)
		if (project.file(extension.getCoverageFile()).exists()) {
			project.plugins.withId('sonarRunner') {
				configureSonarRunner(extension)
			}
		}
	}
	
	private void configureSonarRunner(IstanbulExtension extension) {
		SonarRunnerExtension sonarRunner = 
			project.getExtensions().getByName(SonarRunnerExtension.SONAR_RUNNER_EXTENSION_NAME)
		sonarRunner.sonarProperties {
			property "sonar.javascript.lcov.reportPath" "${extension.getCoverageFile()}"
		}
	}
	
}
