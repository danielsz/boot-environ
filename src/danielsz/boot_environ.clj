(ns danielsz.boot-environ
  {:boot/export-tasks true}
  (:require
   [clojure.java.io :as io]
   [boot.core       :as core]
   [boot.util       :as util]
   [environ.core :refer [env]]))

(core/deftask environ [e env FOO=BAR {kw edn} "The environment map"]
  (core/with-pre-wrap fileset
    (boot.util/info (str "environment " env "\n"))
    (alter-var-root #'env merge env)
    fileset))
