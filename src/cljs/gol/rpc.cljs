(ns gol.rpc
  (:require-macros
    [tailrecursion.javelin :refer [defc defc=]])
  (:require
   [tailrecursion.javelin]
   [tailrecursion.castra :refer [mkremote]]))

(defc state {:boards nil})
(defc error nil)
(defc loading [])

(defc= boards (get state :boards))

(def save-board
  (mkremote 'gol.api/save-board state error loading))

(def get-state
  (mkremote 'gol.api/get-state state error loading))

(defn init []
  (get-state))
