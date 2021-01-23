package com.gjh.learn.maven.plugins.report;

import org.apache.maven.doxia.sink.Sink;
import org.apache.maven.plugin.logging.Log;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.plugins.annotations.ResolutionScope;
import org.apache.maven.project.MavenProject;
import org.apache.maven.reporting.AbstractMavenReport;
import org.apache.maven.reporting.MavenReportException;

import java.util.Locale;

/**
 * Builds an simple report page as an example
 * created on 2021/1/23
 *
 * @author kevinlights
 **/
@Mojo(
        name = "simple",
        defaultPhase = LifecyclePhase.SITE,
        requiresDependencyResolution = ResolutionScope.RUNTIME,
        requiresProject = true,
        threadSafe = true
)
public class SimpleReport extends AbstractMavenReport {

    @Parameter(defaultValue = "${project}", readonly = true, required = true)
    private MavenProject simpleProject;

    @Override
    protected void executeReport(Locale locale) throws MavenReportException {
        Log logger = getLog();
        logger.info("Generating " + getOutputName() + ".html for "
                + simpleProject.getName() + " " + simpleProject.getVersion());
        Sink mainSink = getSink();
        if (mainSink == null) {
            throw new MavenReportException("Could not get the Doxia sink");
        }
        final String text = "Simple Report for " + simpleProject.getName() + " " + simpleProject.getVersion();
        mainSink.head();
        mainSink.title();
        mainSink.text(text);
        mainSink.title_();
        mainSink.head_();

        mainSink.body();

        mainSink.section1();
        mainSink.sectionTitle1();
        mainSink.text(text);
        mainSink.sectionTitle1_();

        mainSink.paragraph();
        mainSink.text("This page provides simple information, like its location: ");
        mainSink.text(simpleProject.getBasedir().getAbsolutePath());
        mainSink.paragraph_();

        mainSink.section1_();
        mainSink.body_();
    }

    @Override
    public String getOutputName() {
        return "simple-report";
    }

    @Override
    public String getName(Locale locale) {
        return "locale-simple-report";
    }

    @Override
    public String getDescription(Locale locale) {
        return "A simple maven report plugin";
    }
}
