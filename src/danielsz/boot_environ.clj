(ns danielsz.boot-environ
  {:boot/export-tasks true}
  (:require
   [clojure.java.io :as io]
   [boot.core       :as core]
   [boot.util       :as util]
   [environ.core :as environ]))

(core/deftask environ [e env FOO=BAR {kw edn} "The environment map"
                       v verbose     bool     "Print env map"]
  (fn [next-task]
    (fn [fileset]
      (when verbose (boot.util/info (str "environment " env "\n")))
      (with-redefs [environ/env (merge environ/env env)]
        (next-task fileset)))))
