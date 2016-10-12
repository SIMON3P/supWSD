# supWSD
supWSD is a supervised word sense disambiguation system.  The flexible framework of supWSD allows users to combine different preprocessing modules, to select features extractors and choose which classifier to use. SupWSD is very light and has very small memory requirements; it provides a simple xml file to configure the system.

## Files & Directories
Name | Description
------------ | -------------
config | Babelnet configuration folder, containing the properties files.
lib | Babelnet libraries folder, containing all the necessary .jar files.
models |  folder contains the models of the preprocessing components (only openNLP).
resource | folder contains the lexical semantic resources (sense inventories).
src/main/java/it/uniroma1/lcl/supWSD | source code package.
LICENSE | license file.
README | this file.
pom.xml | Maven configuration file.
supWSD.xml | supWSD configuration file.
supWSD.xsd | supWSD.xml schema definition. This file describes the elements in supWSD.xml and verify that each item adheres to the description of the element.


## Install

## Requirement
1. This software requires java 8 (JRE 1.8) or higher version.
2. Since supWSD uses JWNL for accessing WordNet, you must define the path of the Wordnet dictionary. In resources/wndictionary/prop.xml you can find this line ```xml<param name="dictionary_path" value="dict" />``` : the value "dict" specifies the path of the WordNet dictionary.

## Configuration

# License
supWSD and its API are licensed under a Creative Commons Attribution-Noncommercial-Share Alike 3.0 License.
This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
