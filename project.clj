(defproject zameha "0.1.0-SNAPSHOT"
  :dependencies [[org.clojure/clojure "1.9.0-RC1"]
                 [org.clojure/core.async "0.3.443"]
                 [ring/ring-jetty-adapter "1.6.3"]
                 [metosin/compojure-api "2.0.0-alpha12"]
                 [clj-audio "0.3.0"]
                 [com.googlecode.soundlibs/jlayer "1.0.1.4"]
                 [com.googlecode.soundlibs/mp3spi "1.9.5.4"]
                 [environ "1.1.0"]]
  :main zameha.core
  :ring {:handler zameha.core/app}
  :plugins [[lein-environ "1.1.0"]])
