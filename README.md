# datacollector-grinder

A simple load tester for [datacollector] (https://github.com/julson/datacollector) 
that writes randomly generated event datausing Grinder.

## Setup

Install [leiningen] (https://github.com/technomancy/leiningen)

Download the project

```
git clone git://github.com/julson/datacollector-grinder.git
cd ./datacollector-grinder
lein deps
```

## Usage

This uses [Grinder] (http://grinder.sourceforge.net/) to run a Clojure
script for testing. Grinder allows for easy thread and agent creation for testing
across multiple machines.

While in the project directory, run:

```
bin/grinder agent start
bin/grinder console start
```

From the Grinder console, navigate to the Script tab and set the working
directory to `$PROJECT_HOME/grinder`.

Right click on `working.properties` and click on the select properties button

Click on the play button on the upper left-hand corner of the Grinder Console 
to start the test


