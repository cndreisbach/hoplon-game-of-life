(ns gol.api
  (:require [tailrecursion.castra :refer [defrpc]]))

(def boards (atom {"Blank" #{}
                   "Starting" #{[3 2] [4 3] [2 4] [3 4] [4 4] ; glider
                                [15 10] [16 10] [17 10] ; oscillator
                                [25 15] [26 15] [27 15] [25 16] [26 17] ; glider
                                }}))

(defrpc get-state []
  {:boards @boards})

(defrpc save-board [name board]
  (swap! boards assoc name board)
  (get-state))

