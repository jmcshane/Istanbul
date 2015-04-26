package com.mcshane.gradle.istanbul

import groovy.json.JsonSlurper

class IstanbulExtension {

	static final String ISTANBUL_EXTENSION_NAME = "istanbul";
	static final String ISTANBUL_TASK_NAME = "istanbul";
	
	private boolean jsonParsed
	
	public String json
	public String taskName
	public String coverageFile
	
	def parseJson() {
		def jsonFile = new File(json).text
		def properties = new JsonSlurper().parseText(jsonFile)
		this.taskName = properties.istanbul_grunt_task
		this.coverageFile = properties.istanbul_coverage_dir
		jsonParsed = true
	}

	def String getTaskName() {
		parseIfNecessary()
		return taskName
	}
	
	def String getCoverageFile() {
		parseIfNecessary()
		return coverageFile
	}
	
	private void parseIfNecessary() {
		if (json != null && !jsonParsed) {
			parseJson()
		}
	}
}
