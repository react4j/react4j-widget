require 'buildr/git_auto_version'
require 'buildr/gpg'
require 'buildr/gwt'

desc 'React4j-Widget: Interoperability with GWT Widget API'
define 'react4j-widget' do
  project.group = 'org.realityforge.react4j.widget'
  compile.options.source = '1.8'
  compile.options.target = '1.8'
  compile.options.lint = 'all'

  project.version = ENV['PRODUCT_VERSION'] if ENV['PRODUCT_VERSION']

  dom_artifact = artifact(:react4j_dom)
  pom.include_transitive_dependencies << dom_artifact
  pom.dependency_filter = Proc.new {|dep| dom_artifact == dep[:artifact]}

  project.processorpath << :react4j_processor
  project.processorpath << :arez_processor

  compile.with :javax_annotation,
               :jsinterop_base,
               :jsinterop_annotations,
               :elemental2_core,
               :elemental2_dom,
               :elemental2_promise,
               :braincheck,
               :arez_core,
               :react4j_core,
               :react4j_dom,
               :gwt_user

  gwt_enhance(project)

  package(:jar)
  package(:sources)
  package(:javadoc)

  doc.
    using(:javadoc,
          :windowtitle => 'React4j Widget API Documentation',
          :linksource => true,
          :timestamp => false,
          :link => %w(https://react4j.github.io/api https://arez.github.io/api https://docs.oracle.com/javase/8/docs/api http://www.gwtproject.org/javadoc/latest/)
    )

  iml.excluded_directories << project._('tmp')
  iml.excluded_directories << project._('node_modules')

  ipr.add_component_from_artifact(:idea_codestyle)
end
