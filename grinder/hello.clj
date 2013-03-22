;;
;; Grinder Hello World!
;;

(import '(net.grinder.script Grinder))

(defn log [& text]
  (.. grinder (getLogger) (info (apply str text))))

(let [grinder Grinder/grinder]
  (fn []
    (fn []
      (log "Hello World!"))))