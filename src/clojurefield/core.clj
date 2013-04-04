(ns clojurefield.core
  (:refer-clojure :exclude [resolve])
  (:use clojurewerkz.urly.core)
  (:import [java.net URI URL]))

(url-like (URL. "http://clojure.org"))
(url-like (URI. "http://clojure.org"))
(url-like "http://clojure.org")

;; unline java.net.URI, valid Internet domain names like "clojure.org" and "amazon.co.uk"
;; will be recognized as hostname, not paths
(url-like "clojure.org")
(url-like "amazon.co.uk")

;; accessing parts of the URL

(resolve (URI. "http://clojure.org") (URI. "/Protocols"))
(resolve (URI. "http://clojure.org") "/Protocols")
(resolve (URI. "http://clojure.org") (URL. "http://clojure.org/Protocols"))
(resolve "http://clojure.org"        (URI. "/Protocols"))
(resolve "http://clojure.org"        (URL. "http://clojure.org/Protocols")) 

;; absolute & relative URLs
(absolute? "/faq")
(relative? "/faq")

(absolute? (java.net.URL. "http://clojure.org"))
(relative? (java.net.URL. "http://clojure.org"))

(let [u (url-like "http://clojure.org")]
  ;; returns a UrlLike instance that represents "http://clojure.org/Protocols"
  (.mutatePath u "/Protocols")
  ;; returns a UrlLike instance that represents "https://clojure.org/"
  (.mutateProtocol u "https")
  ;; returns a UrlLike instance with query string URL-encoded using UTF-8 as encoding
  (encode-query (url-like "http://clojuredocs.org/search?x=0&y=0&q=%22predicate function%22~10"))
  ;; returns a UrlLike instance that represents "http://clojure.org/"
  (-> u (.mutateQuery "search=protocols")
        (.withoutQueryStringAndFragment))
  ;; the same via Clojure API
  (-> u (mutate-query "search=protocols")
        (.withoutQueryStringAndFragment))
  ;; returns a UrlLike instance with the same parts as u but no query string
  (.withoutQuery u)
  ;; returns a UrlLike instance with the same parts as u but no fragment (#hash)
  (.withoutFragment u)
  ;; returns a UrlLike instance that represents "http://clojuredocs.org/search?x=0&y=0&q=%22predicate+function%22~10"
  (-> u (mutate-query "x=0&y=0&q=%22PREDICATE+FUNCTION%22~10")
        (mutate-query-with (fn [^String s] (.toLowerCase s)))))


;; stripping of extra protocol prefixes (commonly found in URLs on the Web)

(eliminate-extra-protocol-prefixes "http://https://broken-cms.com")
(eliminate-extra-protocol-prefixes "https://http://broken-cms.com")

