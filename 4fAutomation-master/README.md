# 4fAutomation

## Description
Android application 4F store regression testing plan automation. Automates all test cases for regression testing of 4F store APK version 1.52.

## Features

## Installation
**4F 1.52 APK**: https://drive.google.com/file/d/1LY476StsOMNc9Y-VZZ45_ts9XTWUdhAP/view?usp=sharing
### Installation Instructions (macOS)

#### Ruby

_Do not use System Ruby which comes with macOS_

__Recommended versions: Ruby 3 or Ruby 2.7__

- Install Ruby on your Mac using Ruby Version Manager (RVM) or rbenv
  -   **RVM** run: `\curl -sSL https://get.rvm.io | bash -s stable`
  - Close and reopen your terminal to load RVM
  - Verify that RVM is installed correctly by running: `rvm --version`
  - Run to install Ruby 3.0 : `rvm install 3.0.0`
- To check if Ruby is installed, run: ruby -v

#### Homebrew

- Install Homebrew, a package manager for macOS
  -   Run: `/bin/bash -c "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/HEAD/install.sh)"`
  -   Verify that brew is installed: `brew -v`
  
  
#### Node.js

- Use Homebrew to install Node.js, which includes npm (Node Package Manager)
  - Run: `brew install node`
- To check the Node.js version, run: `node -v`


#### Appium CLI

- Install the Appium CLI (Command Line Interface) tool for launching Appium server instances
- Run: `npm install -g appium`
- To check the Appium version, run: `appium -v`

Note: Install Appium version 1.x.x (avoid Appium 2.x Beta)

#### Appium Server and Inspector Apps

- Download and install Appium GUI Server (Appium Desktop) and Inspector apps
  -  Appium GUI Server : https://github.com/appium/appium-desktop/releases/tag/v1.22.3-4
  -  Appium Inspector: https://github.com/appium/appium-inspector/releases

#### Java

Note: I am using Java 16

- Install Java on your Mac from any source
  - Using already installed brew, run: `brew install java`
  - Verify: `brew install java`
- Set Java to PATH if it's not done automatically
Example configuration:
  - `export JAVA_HOME=$(/usr/libexec/java_home)`
  - `export PATH=$JAVA_HOME/bin:$PATH`

#### Appium Doctor

- Install appium-doctor using npm to diagnose your setup installations
- Run: `npm install -g appium-doctor`
- Check the setup using: `appium-doctor`
- Resolve any errors reported by appium-doctor

#### IntelliJ IDEA

- Download and install IntelliJ IDEA Community edition: https://www.jetbrains.com/idea/download/#section=mac
- Install TestNG and Maven plugins in IntelliJ IDEA

### Android Only

#### Android Studio

- Download and install Android Studio: https://developer.android.com/studio
- Open Android Studio and go through the initial setup wizard
- Install recommended components
- Set ANDROID_HOME
- Set the ANDROID_HOME environment variable to the Android SDK location
- Example configuration:
  - `export ANDROID_HOME=/Users/$USER/Library/Android/sdk`
  - `export PATH=$ANDROID_HOME/emulator:$ANDROID_SDK/tools:$PATH`
  - `export PATH=${PATH}:$ANDROID_HOME/tools:$ANDROID_HOME/platform-tools`

*Please note that these instructions are for macOS.* 



### Installation Instructions (Windows)

#### Ruby

- Install Ruby on your Windows machine using RubyInstaller
  - Go to the RubyInstaller downloads page: https://rubyinstaller.org/downloads/
  - Choose the Ruby version you want to install (Ruby 3 or Ruby 2.7) and download the corresponding Ruby+Devkit version
  - Run the installer and follow the instructions
  - After installation, open a new command prompt or PowerShell window
  - Verify the Ruby installation by running: `ruby -v`

#### Chocolatey

- Install Chocolatey, a package manager for Windows: https://chocolatey.org/install
  - Open PowerShell as an administrator
  - Run the following command to install Chocolatey: 
`Set-ExecutionPolicy Bypass -Scope Process -Force; [System.Net.ServicePointManager]::SecurityProtocol = [System.Net.ServicePointManager]::SecurityProtocol -bor 3072; iex ((New-Object System.Net.WebClient).DownloadString('https://community.chocolatey.org/install.ps1'))`
  - If no errors appeared, you are ready to use Chocolatey! 
  - Verify: `choco` or `choco -?`

#### Node.js

- Use Chocolatey to install Node.js, which includes npm (Node Package Manager).
-   Open a new command prompt or PowerShell window as an administrator.
-   Run the following command to install Node.js: `choco install nodejs`
-   Verify : `node -v`

#### Appium CLI

- Install the Appium CLI (Command Line Interface) tool for launching Appium server instances
-   Open a new command prompt or PowerShell window
-   Run the following command to install the Appium CLI:`npm install -g appium`
-   Verify: `appium -v`
-   Install Appium version 1.x.x (avoid Appium 2.x Beta)

#### Appium Server and Inspector Apps

- Download:
  -  Appium GUI Server (Appium Desktop): https://github.com/appium/appium-desktop/releases/tag/v1.22.3-4
  -  Inspector apps: https://github.com/appium/appium-inspector/releases

#### Java

- Install Java on your Windows machine.
  -  Go to the Java SE Development Kit (JDK) downloads page: https://www.oracle.com/java/technologies/downloads/
  -  Download and run the installer for the JDK version compatible with your system
  - Follow the instructions in the installer
  - Set the JAVA_HOME environment variable to the JDK installation path

#### Appium Doctor

- Install appium-doctor using npm to diagnose your setup installations
  - Open a new command prompt or PowerShell window
  - Run the following command to install appium-doctor: `npm install -g appium-doctor`
  - Check the setup using: `appium-doctor`
- Resolve any errors reported by appium-doctor

#### IntelliJ IDEA

- Download and install IntelliJ IDEA Community edition for Windows from the official website: https://www.jetbrains.com/idea/download/#section=windows
- Install TestNG and Maven plugins in IntelliJ IDEA

### Android Only

#### Android Studio

- Download and install Android Studio for Windows from the official website: https://developer.android.com/studio
  -  Open Android Studio and go through the initial setup wizard.
  - Install recommended components.
- Set ANDROID_HOME
  - Set the ANDROID_HOME environment variable to the Android SDK location.
  - Go to the "Advanced" tab and click on the "Environment Variables" button.
  - Click on "New" under the "System variables" section.
  - Set the variable name as ANDROID_HOME and the variable value as the path to the Android SDK directory

### Setting up Real Android Device

- Enable USB debugging on your Android device.
  - Go to Settings > System > About Phone.
  - Tap on "Build Number" 7 to 8 times to enable Developer Options.
  - Go back to Settings and open Developer Options.
  - Enable "USB Debugging".

### Setting up Emulator

- Set up at least one working emulator.
  - Open Android Studio and go to Configure > AVD Manager.
  - Create a virtual device (AVD) with the desired specifications.
  - Download the required OS image if not already available.
  - Start the AVD.

*Choosing real device is more beneficial for testing Real-world scenarios*

That's it! You have completed the installation process. Ensure that all the necessary components are correctly installed and configured by running the respective version commands.

**If you encounter any issues during the installation, refer to the official documentation for the respective tools and frameworks or seek assistance from the community.

## To launch test

**Launching Appium Server:**

Open the Appium GUI Server (Appium Desktop) from the downloaded and installed location.
Configure the desired settings for the Appium server and start server.
Appium Server log should appear with status: The server is running


**Opening the project in IntelliJ IDEA:**

Launch IntelliJ IDEA and open the project that contains the regression testing plan automation code.
Running the test cases:

In the project structure, navigate to the test cases file (where the methods annotated with @Test are defined).
Run the tests by either clicking the run icon next to each @Test method or by running the entire test suite by clicking run using Intelij compiler. Or to run all tests using listener right click on all-class-tests.xml in TestSuitePackage and running.

## Usage
  1. Creating an instance's of Tasks class.
  2. Call the setUp() method to set up the test environment before each test case.
  3. Implement separate methods for each test case, following the TestNG @Test annotation.
  4. Use the provided page objects to interact with the app screens during test execution.
  5. Use the provided installations and utility methods for app installation and setup.
  6. Add documentation and assertions within each test case to ensure test correctness.
  7. Optionally, use the TestNG framework annotations to group and configure test cases.

## Author

**Ivo Sorokins**

## Acknowledgements

TDLSchool course: https://tdlschool.com/courses/mobile-test-automation-junior

## Resources

Appium documentation: https://appium.io/docs/en/2.0/

About Android studio: https://developer.android.com/about

Java documentation: https://docs.oracle.com/en/java/

Chocolatey documentation,course: https://community.chocolatey.org/courses

Getting Started Intellij: https://www.jetbrains.com/help/idea/getting-started.html

HomeBrew documentation: https://docs.brew.sh/

Java Dataproviders: https://docs.oracle.com/cd/E17824_01/dsc_docs/docs/jscreator/apis/dataprovider/com/sun/data/provider/DataProvider.html

TestNG documentation: https://testng.org/doc/documentation-main.html

Maven documentation: https://maven.apache.org/guides/index.html

GitHub docs: https://docs.github.com/en

GitIgnore: https://www.toptal.com/developers/gitignore

Temporary, testing emails: https://temp-mail.org/en/

Delimiter: https://www.computerhope.com/jargon/d/delimite.htm

Youtube tutorials:
  - setting up JDK on windows: 
 https://www.youtube.com/watch?v=-O4QVijnA7Y&pp=ygUcd2luZG93cyBzZXR0aW5nIHVwIGphdmEgcGF0aA%3D%3D
  - Dataproviders: https://www.youtube.com/watch?v=O8yP672fogE
 
**My stack overflow question**:
  https://stackoverflow.com/questions/76301258/method-requires-a-dataprovider-even-when-dataprovider-for-test-method-is-pro
