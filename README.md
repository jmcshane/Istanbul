# Istanbul
This plugin allows creation of istanbul test reports within gradle execution and optional passing of the report to SonarQube.

In order to configure the Istanbul task in conjunction with the Grunt configuration, this plugins allows a JSON file to configure the project properties.

## build.gradle

```groovy
istanbul {
	json = 'configuration.json'
}
```

Set the values of the properties `istanbul_coverage_dir` and `istanbul_grunt_task` within the `configuration.json` file.

## configuration.json

```json
{
	"istanbul_coverage_dir" : "istanbul/coverage/output",
	"istanbul_grunt_task" : "build"
}
```

Then, this `istanbul_coverage_dir` property should be passed to the `makeReport` configuration within the project `Gruntfile.js`.

## Gruntfile.js

```javascript
grunt.initConfig({

	...
	
	config = grunt.file.readJSON('configuration.json')
	
    makeReport: {
      src: <REPORT-SOURCE>,
      options: {
        type: 'lcov',
        dir: '<%= config.istanbul_coverage_dir %>',
        print: 'detail'
      }
    }
});
```

The Istanbul Grunt task should be the task that you want run during the Gradle build to run the tests and generate the report.
The Grunt task can then be configured further within the project `Gruntfile.js`. 


