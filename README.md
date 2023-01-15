Purity HUD
==============
Purity HUD is a modified version od Mini HUD that disables some of it's features in order to make it fair-play. 

See original project at: https://github.com/maruohon/minihud

Mini HUD is a tiny client-side mod for Minecraft. that adds the coordinates, looking angle and current speed to the screen.
For more information and the downloads (compiled builds), see http://minecraft.curseforge.com/projects/minihud

[DOWNLOAD LATEST VERSION HERE](https://github.com/wefhy/purityhud/releases)

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
