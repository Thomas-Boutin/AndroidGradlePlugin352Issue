# AndroidGradlePlugin352Issue
* Repository showing compiling issue with android gradle plugin 3.5.2+ and databinding.
* The issue happens when we want to access an observable property of a field, which is itself encapsulated in an observable wrapper (like ObservableField or LiveData)
* The issue happens with the use of a two way binding converter
* It results in a kapt exception : **cannot generate view binders java.lang.IndexOutOfBoundsException: Index: -1, Size: 0**

## Details for build tools and Gradle
* Gradle version: 5.4.1.
* Android Plugin Version : 3.5.3.
* Module Compile Sdk Version: 29.
* Module Build Tools Version: 29.0.2.
* Android SDK Tools version: 26.1.1.

## Branches
* master : branch which demonstrates the issue with android gradle plugin 3.5.3
* androidbuildgradle3.5.1: branch which deponstrates a ok build with android gradle plugin 3.5.1

## Steps to reproduce
* Activate the databinding
* Set your android gradle plugin to 3.5.2+
* Create a sample class (ie: Foo) which contains an observable field (ie: val bar: ObservableField<Int>)
* Create a Converter with an associated inverse method (ie: intToString / stringToInt)
* Create a databinding layout with a TextView
* Import the converter in the <data> block
* Declare an observable variable which encapsulates the sample type (ie: ObservableField<Foo> / LiveData<Foo>) in the <data> block
* Set the two way binding on the textview field, using the converter (ie: android:text="@{Conv.intToString(foo.bar)}")
