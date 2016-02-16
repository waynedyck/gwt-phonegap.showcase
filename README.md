# gwt-phonegap.showcase

The **gwt-phonegap.showcase** project is composed of two parts. The first part is the GWT source code and is located in the **gwt-phonegap-showcase/gwt/** directory. The second is the [Apache Cordova](https://cordova.apache.org/) app and is located in the **gwt-phonegap.showcase/showcase/** directory.

If you are new to Cordova,

> Apache Cordova is an open-source mobile development framework. It allows you to use standard web technologies such as HTML5, CSS3, and JavaScript for cross-platform development, avoiding each mobile platforms' native development language. Applications execute within wrappers targeted to each platform, and rely on standards-compliant API bindings to access each device's sensors, data, and network status. 

Before you begin you might want to refer to the Cordova [command-line interface (CLI) guide](https://cordova.apache.org/docs/en/latest/guide/cli/index.html) to ensure you have the latest Cordova command-line tools installed. The showcase project has been setup to work with Cordova 6.0.0. 

##How to run the showcase project

The **gwt-phonegap.showcase/showcase/www/** directory contains a current build of the compiled GWT showcase source. The Android and iOS platforms are also already installed. If you want to try the showcase project on your Android or iPhone device simply go into the **gwt-phonegap.showcase/showcase/** directory and run either,

```cordova build android```

to build a debug apk for Android or,

```cordova build ios```

to build the project for your iPhone.

The **gwt-phonegap.showcase/showcase/platforms/** directory contains both the ```android``` and ```ios``` platforms. Each of these directories contain the project files you can use to open in either [Android Studio](http://developer.android.com/sdk/index.html) or [Xcode](https://developer.apple.com/xcode/). From each respective IDE you can then choose to deploy the showcase app to either an attached device or emulator for testing.

##How to build the GWT source code

You can build the GWT source code by going into the **gwt-phonegap-showcase/gwt/** directory and running

```mvn package```

When the build process finishes you will have in the **gwt-phonegap.showcase/gwt/target/gwtphonegap-showcase-gwt-3.4.0.0-SNAPSHOT/** directory another directory called **showcase** that contains all the compiled JavaScript permutations for the project. Delete the old **showcase** directory located in the **gwt-phonegap.showcase/showcase/www/** directory and copy the new one in its place. Once you have done that you can run the ```cordova build``` command to rebuild the Cordova project.
