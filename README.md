# maven plugins learn



Learn how to develop maven plugins. 



hello-maven-plugin

- sayhi mojo
- report mojo

plugin-test

- test hello-maven-plugin



note:

1. the report mojo requires doxia to render Sink content.
2. if you want to inject project parameter, you should add `required = true`
3. you should add execution id to different executions.