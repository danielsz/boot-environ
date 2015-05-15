(set-env!
  :source-paths #{"src"}
  :dependencies '[[boot/core "2.0.0-rc13" :scope "provided"]
                  [adzerk/bootlaces "0.1.11" :scope "test"]
                  [environ "1.0.0"]])

(require '[adzerk.bootlaces :refer :all])

(def +version+ "0.0.2")
(bootlaces! +version+)

(task-options!
 aot {:namespace '#{danielsz.boot-environ}}
 pom {:project 'danielsz/boot-environ
      :version +version+
      :scm {:name "git"
            :url "https://github.com/danielsz/boot-environ"}})

(deftask build
  "Build jar and install to local repo."
  []
  (comp (aot) (pom) (jar) (install)))

