# React4j-Widget

[![Build Status](https://secure.travis-ci.org/react4j/react4j-widget.png?branch=master)](http://travis-ci.org/react4j/react4j-widget)
[<img src="https://img.shields.io/maven-central/v/org.realityforge.react4j.widget/react4j-widget.svg?label=latest%20release"/>](http://search.maven.org/#search%7Cga%7C1%7Cg%3A%22org.realityforge.react4j.widget%22)

This library provides a GWT widget that renders a React4j element.

## Quick Start

The simplest way to use component;

* add the following dependencies into the build system. i.e.

```xml
<dependency>
   <groupId>org.realityforge.react4j.widget</groupId>
   <artifactId>react4j-widget</artifactId>
   <version>1.47</version>
</dependency>
```

* add the snippet `<inherits name="react4j.widget.ReactWidget"/>` into the .gwt.xml file.

* interact with the widget from within the browser.

```java
RootLayoutPanel.get().add( new ReactWidget( h1( "Hello World" ) )  );
```

# More Information

For more information about component, please see the [Website](https://react4j.github.io/react4j-widget). For the
source code and project support please visit the [GitHub project](https://github.com/react4j/react4j-widget).

# Contributing

The component was released as open source so others could benefit from the project. We are thankful for any
contributions from the community. A [Code of Conduct](CODE_OF_CONDUCT.md) has been put in place and
a [Contributing](CONTRIBUTING.md) document is under development.

# License

The component is licensed under [Apache License, Version 2.0](LICENSE).
