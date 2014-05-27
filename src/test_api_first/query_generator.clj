(ns test_api_first.query-generator
	(:require [crypto.random :as cryran]))


(defn cat [] (rand-nth ["IAB1" "IAB1-1" "IAB9" "IAB9-30" "books" "games"]))
(defn bcat [] (rand-nth ["IAB25" "IAB26" "IAB9"]))
(defn randid [byte] (cryran/hex byte))
(defn randbool [] (rand-nth [0 1]))
(defn randurl [size] (str "http://www." (cryran/url-part size) ".com/" (cryran/url-part size)))
(defn randcountry [] (rand-nth ["FRA" "USA" "UKR" "RUS" "GER" "LTU" "GBR" "FIN" "DNK" "GEO" "CAN" "BLR" "BEL" "LUX" "MEX" "MDA" "ROM" "PER" "PAN" "JPN" "LVA" "GIN" "GUY" "HTI" "VAT" "KAZ" "ITA" "ISR" "JAM" "JOR"]))
(defn randuseragent [] (rand-nth [
	"Mozilla/5.0 (X11; U; Linux i686; es-ES; rv:1.9.1.7) Gecko/20091222 SUSE/3.5.7-1.1.1 Firefox/3.5.7"
	"Mozilla/5.0 (Windows; U; Windows NT 6.1; en-AU; rv:1.9.2.14) Gecko/20110218 Firefox/3.6.14"
	"Mozilla/5.0 (X11; U; Linux x86_64; en-US) AppleWebKit/540.0 (KHTML,like Gecko) Chrome/9.1.0.0 Safari/540.0"
	"Mozilla/5.0 (X11; U; Linux armv7l; en-US) AppleWebKit/534.16 (KHTML, like Gecko) Chrome/10.0.648.204 Safari/534.16"
	"Mozilla/5.0 (Windows; U; Windows NT 5.2; en-US) AppleWebKit/534.10 (KHTML, like Gecko) Chrome/8.0.558.0 Safari/534.10"
	"Mozilla/5.0 (Windows; U; Windows NT 6.1; de; rv:1.9.1.1) Gecko/20090715 Firefox/3.5.1"
	"Mozilla/5.0 (X11; U; Linux i686; en-GB; rv:1.9.1.15) Gecko/20101027 Fedora/3.5.15-1.fc12 Firefox/3.5.15"
	"Mozilla/5.0 (X11; U; Linux x86_64; en-US) AppleWebKit/534.16 (KHTML, like Gecko) Ubuntu/10.10 Chromium/10.0.648.127 Chrome/10.0.648.127 Safari/534.16"
	"Mozilla/5.0 (Macintosh; Intel Mac OS X 10_9_3) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/34.0.1847.137 Safari/537.36"
	"Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10_5_8; en-US) AppleWebKit/534.10 (KHTML, like Gecko) Chrome/8.0.552.224 Safari/534.10"
	"Opera/9.80 (Macintosh; Intel Mac OS X 10.6.8; U; de) Presto/2.9.168 Version/11.52"
	"Mozilla/5.0 (Macintosh; Intel Mac OS X 10_9_3) AppleWebKit/537.76.4 (KHTML, like Gecko) Version/7.0.4 Safari/537.76.4"
	"Mozilla/5.0 (X11; U; Linux x86_64; en-US) AppleWebKit/534.16 (KHTML, like Gecko) Ubuntu/10.10 Chromium/10.0.648.127 Chrome/10.0.648.127 Safari/534.16"
	"Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.1; de) Opera 11.51" "Opera/9.80 (Windows NT 6.1; Opera Tablet/15165; U; en) Presto/2.8.149 Version/11.1"
	"Mozilla/5.0 (Windows NT 5.1; U; zh-cn; rv:1.9.1.6) Gecko/20091201 Firefox/3.5.6 Opera 10.70" "Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 6.0; en) Opera 11.00"
	"Mozilla/4.0 (compatible; MSIE 10.0; Windows NT 6.1; Trident/5.0)" "Mozilla/5.0 (Windows; U; Windows NT 6.1; es-ES) AppleWebKit/531.22.7 (KHTML, like Gecko) Version/4.0.5 Safari/531.22.7"
	"Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10_5_8; en-US) AppleWebKit/534.16 (KHTML, like Gecko) Chrome/10.0.648.127 Safari/534.16"]))
(defn randip [] (str (+ 1 (rand-int 256)) "." (rand-int 256) "." (rand-int 256) "." (rand-int 256)))
(defn randattr [] (rand-int 15))
(defn randbid [] (+ 0.01 (rand 0.5)))
(defn randdimension [] (+ 120 (int (rand 481))))

(defn query-generator [] (format "{ \"app\": { \"cat\": [ \"%s\", \"%s\", \"%s\", \"%s\", \"%s\", \"%s\" ], \"id\": \"%s\", \"name\": \"Adfonic test\", \"publisher\": { \"id\": \"%s\", \"name\": \"%s\" }, \"storeurl\": \"%s\" }, \"at\": 2, \"badv\": [ \"%s\", \"%s\", \"%s\", \"%s\" ], \"bcat\": [ \"%s\", \"%s\" ], \"device\": { \"connectiontype\": %s, \"devicetype\": %s, \"geo\": { \"city\": \"Brookline\", \"country\": \"%s\", \"region\": \"MA\", \"zip\": \"02445\" }, \"ip\": \"%s\", \"js\": 1, \"language\": \"en\", \"ua\": \"%s\" }, \"id\": \"%s\", \"imp\": [ { \"banner\": { \"battr\": [ %s, %s, %s ], \"btype\": [ %s ], \"h\": %s, \"pos\": %s, \"w\": %s }, \"bidfloor\": %s, \"displaymanager\": \"mopub\", \"id\": \"%s\", \"instl\": %s, \"tagid\": \"%s\" } ] }" (cat) (cat) (cat) (cat) (cat) (cat) (randid 16) (randid 20) (randid 4) (randurl 5) (randurl 5) (randurl 6) (randurl 4) (randurl 3) (bcat) (bcat) (randbool) (randbool) (randcountry) (randip) (randuseragent) (randid 18) (randattr) (randattr) (randattr) (randattr) (randdimension) (randattr) (randdimension) (randbid) (randattr) (randattr) (randid 16)))