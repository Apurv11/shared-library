pipelineJob('npm-dsl-job-1') {
    definition {
        cps {
            script(readFileFromWorkspace('npm1.groovy'))
            sandbox()
        }
    }
}

pipelineJob('npm-dsl-job-1') {
    definition {
        cps {
            script(readFileFromWorkspace('npm2.groovy'))
            sandbox()
        }
    }
}
