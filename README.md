Purity HUD
==============
Purity HUD is a modified version od Mini HUD that disables some of it's features in order to make it fair-play. 

See original project at: https://github.com/maruohon/minihud

Mini HUD is a tiny client-side mod for Minecraft. that adds the coordinates, looking angle and current speed to the screen.
For more information and the downloads (compiled builds), see http://minecraft.curseforge.com/projects/minihud

[![DOWNLOAD LATEST VERSION HERE](https://img.shields.io/github/downloads/wefhy/purityhud/total?style=for-the-badge&label=DOWNLOAD%20LATEST%20VERSION%20HERE&logo=github)](https://github.com/wefhy/purityhud/releases)

### Stats (versions)
[![1.20.2](https://img.shields.io/github/downloads/wefhy/purityhud/purityhud-1.20.2/total?label=1.20.2&style=flat-square)](https://github.com/wefhy/purityhud/releases/tag/purityhud-1.20.2)
[![1.20.1](https://img.shields.io/github/downloads/wefhy/purityhud/purityhud-1.20.1/total?label=1.20.1&style=flat-square)](https://github.com/wefhy/purityhud/releases/tag/purityhud-1.20.1)
[![1.19.4](https://img.shields.io/github/downloads/wefhy/purityhud/purityhud-1.19.4/total?label=1.19.4&style=flat-square)](https://github.com/wefhy/purityhud/releases/tag/purityhud-1.19.4)
[![1.19.3](https://img.shields.io/github/downloads/wefhy/purityhud/purityhud-1.19.3/total?label=1.19.3&style=flat-square)](https://github.com/wefhy/purityhud/releases/tag/purityhud-1.19.3)
[![1.19.2](https://img.shields.io/github/downloads/wefhy/purityhud/purityhud-1.19.x/total?label=1.19.2&style=flat-square)](https://github.com/wefhy/purityhud/releases/tag/purityhud-1.19.x)
[![1.18.2](https://img.shields.io/github/downloads/wefhy/purityhud/purityhud-1.18.2/total?label=1.18.2&style=flat-square)](https://github.com/wefhy/purityhud/releases/tag/purityhud-1.18.2)
[![1.17](https://img.shields.io/github/downloads/wefhy/purityhud/purityhub-1.17/total?label=1.17&style=flat-square)](https://github.com/wefhy/purityhud/releases/tag/purityhub-1.17)
[![1.16](https://img.shields.io/github/downloads/wefhy/purityhud/purityhub/total?label=1.16&style=flat-square)](https://github.com/wefhy/purityhud/releases/tag/purityhub)

Verification
=========
As of current version, PurityHud builds are repeatable. It means that:
 - jar file compiled from version 1.18.2 (commt `06fbd5`) sholud have md5 sum of `a7c37ef0b96dad6fd1effc3ad2e519ac`
 - jar file compiled from version 1.19.x (commt `869fde`) sholud have md5 sum of `fc98850102f8191680822b13de674632`

Compiling
=========
* Clone the repository
* Add `org.gradle.jvmargs=-Xmx4096m` to your system-level `gradle-wrapper.properties` (not sure why it needs to be in system level to work)
* Open a command prompt/terminal to the repository directory
* run 'gradlew build' (or try '.\gradlew build' if this fails with Powershell)
* The built jar file will be in build/libs/
