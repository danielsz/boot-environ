(ns danielsz.boot-environ
  {:boot/export-tasks true}
  (:require
   [clojure.java.io :as io]
   [boot.core       :as core]
   [boot.util       :as util]))

(def env-file ".lein-env")

(core/deftask environ [e env FOO=BAR {kw edn} "The environment map"]
  (core/with-pre-wrap fileset
    (boot.util/info (str "environment " env "\n"))
    (spit env-file (pr-str env))
    fileset))
