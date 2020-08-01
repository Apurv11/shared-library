pipelineJob('python_dsl_job_example') {
    definition {
        cps {
            script(readFileFromWorkspace('pipeline.groovy'))
            sandbox()
        }
    }
}
