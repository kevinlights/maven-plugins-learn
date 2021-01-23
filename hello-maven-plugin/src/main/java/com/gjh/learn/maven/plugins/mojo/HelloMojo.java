package com.gjh.learn.maven.plugins.mojo;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

/**
 * created on 2021/1/23
 *
 * @author kevinlights
 */
@Mojo(name = "sayhi")
public class HelloMojo extends AbstractMojo {

    @Parameter(property = "sayhi.greeting", defaultValue = "Hello World!")
    private String greeting;

    @Parameter
    private boolean flag;

    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {
        getLog().info(greeting);
        getLog().info(String.valueOf(flag));
    }
}
