package com.mcshane.gradle.istanbul

import org.gradle.api.Plugin
import org.gradle.api.Project

class IstanbulPlugin implements Plugin<Project> {

	void apply(Project project) {
		def extension = 
			project.getExtensions().create(IstanbulExtension.ISTANBUL_EXTENSION_NAME, IstanbulExtension.class);
		project.getTasks().create(IstanbulExtension.ISTANBUL_TASK_NAME) { task ->
			task.dependsOn "grunt-${extension.taskName}"
		}
	}
}