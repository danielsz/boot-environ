(ns danielsz.boot-environ
  {:boot/export-tasks true}
  (:require
   [clojure.java.io :as io]
   [boot.core       :as core]
   [boot.util       :as util]))

(def env-file ".lein-env")

(core/deftask environ [e env FOO=BAR {kw edn} "The environment map"]
  (core/with-pre-wrap fileset
    (alter-var-root #'environ.core/env merge env)
    fileset))
