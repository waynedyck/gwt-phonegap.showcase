function showcase(){
  var $intern_23 = '', $intern_32 = '" for "gwt:onLoadErrorFn"', $intern_30 = '" for "gwt:onPropertyErrorFn"', $intern_33 = '#', $intern_88 = '.cache.js', $intern_35 = '/', $intern_59 = '059322EACDBDA369FE91125EED19DF30', $intern_60 = '0E67136807CC62DB4646F9073335DFA7', $intern_61 = '0EBA1EAD558B2E0FD3ADBDEE32C1EFFB', $intern_62 = '12BC1FA3C775364BD03A79EE1B9AD258', $intern_63 = '143CC5117D485F4FF24AE34A5BDF7C32', $intern_64 = '1AE0B4F5C5D9C0F95C0F531A7B98E6F9', $intern_65 = '28434AEA0334A3788AE5791605D8D1E5', $intern_66 = '42D77F67AEC293BA89D102178183B8BA', $intern_67 = '48B016B72218F7DC290BFFBC157CD12C', $intern_68 = '4BC5118DD08E005EA68FCB5F05D4AD1E', $intern_69 = '5BE3A417E5897FB6012E0C8ABD820332', $intern_70 = '6335D05E4D426CA6A6ADEF1750A7E0E3', $intern_71 = '63AFAA0C0778B48ED21E812956411FB8', $intern_72 = '76D9BCF3B47F2FD62C68B51710F09AC4', $intern_73 = '809719F268CF051D9E7D9BC918CB8D7D', $intern_74 = '84299138A261D0E74DC2B43AD05038A2', $intern_75 = '9D1D5E09CC1B288FF22BF2FE820139FE', $intern_87 = ':', $intern_24 = '::', $intern_11 = '<html><head><\/head><body><\/body><\/html>', $intern_27 = '=', $intern_34 = '?', $intern_76 = 'A1FAFE310F52671432CE4E47F0AED109', $intern_77 = 'A499CB7188CF92D70956FB7B3E02EA61', $intern_29 = 'Bad handler "', $intern_78 = 'C5ADD626EBA8AD7B907E1F3A73ED9073', $intern_79 = 'D07E56495A7861B03FDB34AB285F76B9', $intern_80 = 'D8FB11E44F7CC8406298B51A89DCB578', $intern_16 = 'DOMContentLoaded', $intern_6 = 'DUMMY', $intern_81 = 'EB9DA336FE49C74E5DF2FC26F15FC04B', $intern_82 = 'F1D442F3D04C6672FC8CD8566E32450B', $intern_83 = 'F2CA2CA4F575B9D258D01EA31ECFA8F0', $intern_84 = 'F5B30F99F001E54EE9AD251687491BE6', $intern_85 = 'F66AA6C59663427CE42CD13459B6A893', $intern_86 = 'F85153AAE4094C17D073D992A66E3171', $intern_42 = 'android', $intern_44 = 'android_tablet', $intern_40 = 'base', $intern_38 = 'baseUrl', $intern_1 = 'begin', $intern_48 = 'blackberry', $intern_7 = 'body', $intern_0 = 'bootstrap', $intern_37 = 'clear.cache.gif', $intern_26 = 'content', $intern_49 = 'desktop', $intern_90 = 'end', $intern_54 = 'file://', $intern_2 = 'gwt.codesvr.showcase=', $intern_3 = 'gwt.codesvr=', $intern_31 = 'gwt:onLoadErrorFn', $intern_28 = 'gwt:onPropertyErrorFn', $intern_25 = 'gwt:property', $intern_19 = 'head', $intern_8 = 'iframe', $intern_36 = 'img', $intern_45 = 'ipad', $intern_46 = 'iphone', $intern_13 = 'javascript', $intern_9 = 'javascript:""', $intern_89 = 'loadExternalRefs', $intern_20 = 'meta', $intern_41 = 'mgwt.os', $intern_43 = 'mobile', $intern_50 = 'mobile.user.agent', $intern_51 = 'mobilesafari', $intern_18 = 'moduleRequested', $intern_17 = 'moduleStartup', $intern_21 = 'name', $intern_56 = 'no', $intern_52 = 'not_mobile', $intern_53 = 'phonegap.env', $intern_10 = 'position:absolute; width:0; height:0; border:none; left: -1000px; top: -1000px; !important', $intern_47 = 'retina', $intern_12 = 'script', $intern_57 = 'selectingPermutation', $intern_4 = 'showcase', $intern_58 = 'showcase.devmode.js', $intern_39 = 'showcase.nocache.js', $intern_22 = 'showcase::', $intern_5 = 'startup', $intern_15 = 'undefined', $intern_14 = 'var $wnd = window.parent;', $intern_55 = 'yes';
  var $wnd = window;
  var $doc = document;
  sendStats($intern_0, $intern_1);
  function isHostedMode(){
    var query = $wnd.location.search;
    return query.indexOf($intern_2) != -1 || query.indexOf($intern_3) != -1;
  }

  function sendStats(evtGroupString, typeString){
    if ($wnd.__gwtStatsEvent) {
      $wnd.__gwtStatsEvent({moduleName:$intern_4, sessionId:$wnd.__gwtStatsSessionId, subSystem:$intern_5, evtGroup:evtGroupString, millis:(new Date).getTime(), type:typeString});
    }
  }

  showcase.__sendStats = sendStats;
  showcase.__moduleName = $intern_4;
  showcase.__errFn = null;
  showcase.__moduleBase = $intern_6;
  showcase.__softPermutationId = 0;
  showcase.__computePropValue = null;
  var __gwt_isKnownPropertyValue = function(){
    return false;
  }
  ;
  var __gwt_getMetaProperty = function(){
    return null;
  }
  ;
  __propertyErrorFunction = null;
  function installScript(filename){
    var frameDoc;
    function getInstallLocationDoc(){
      setupInstallLocation();
      return frameDoc;
    }

    function getInstallLocation(){
      setupInstallLocation();
      return frameDoc.getElementsByTagName($intern_7)[0];
    }

    function setupInstallLocation(){
      if (frameDoc) {
        return;
      }
      var scriptFrame = $doc.createElement($intern_8);
      scriptFrame.src = $intern_9;
      scriptFrame.id = $intern_4;
      scriptFrame.style.cssText = $intern_10;
      scriptFrame.tabIndex = -1;
      $doc.body.appendChild(scriptFrame);
      frameDoc = scriptFrame.contentDocument;
      if (!frameDoc) {
        frameDoc = scriptFrame.contentWindow.document;
      }
      frameDoc.open();
      frameDoc.write($intern_11);
      frameDoc.close();
      var frameDocbody = frameDoc.getElementsByTagName($intern_7)[0];
      var script = frameDoc.createElement($intern_12);
      script.language = $intern_13;
      var temp = $intern_14;
      script.text = temp;
      frameDocbody.appendChild(script);
    }

    function setupWaitForBodyLoad(callback){
      function isBodyLoaded(){
        if (typeof $doc.readyState == $intern_15) {
          return typeof $doc.body != $intern_15 && $doc.body != null;
        }
        return /loaded|complete/.test($doc.readyState);
      }

      var bodyDone = false;
      if (isBodyLoaded()) {
        bodyDone = true;
        callback();
      }
      var onBodyDoneTimerId;
      function onBodyDone(){
        if (!bodyDone) {
          bodyDone = true;
          callback();
          if ($doc.removeEventListener) {
            $doc.removeEventListener($intern_16, onBodyDone, false);
          }
          if (onBodyDoneTimerId) {
            clearInterval(onBodyDoneTimerId);
          }
        }
      }

      if ($doc.addEventListener) {
        $doc.addEventListener($intern_16, function(){
          onBodyDone();
        }
        , false);
      }
      var onBodyDoneTimerId = setInterval(function(){
        if (isBodyLoaded()) {
          onBodyDone();
        }
      }
      , 50);
    }

    function installCode(code){
      var docbody = getInstallLocation();
      var script = getInstallLocationDoc().createElement($intern_12);
      script.language = $intern_13;
      script.text = code;
      docbody.appendChild(script);
    }

    showcase.onScriptDownloaded = function(code){
      setupWaitForBodyLoad(function(){
        installCode(code);
      }
      );
    }
    ;
    sendStats($intern_17, $intern_18);
    var script = $doc.createElement($intern_12);
    script.src = filename;
    $doc.getElementsByTagName($intern_19)[0].appendChild(script);
  }

  function processMetas(){
    var metaProps = {};
    var propertyErrorFunc;
    var onLoadErrorFunc;
    var metas = $doc.getElementsByTagName($intern_20);
    for (var i = 0, n = metas.length; i < n; ++i) {
      var meta = metas[i], name = meta.getAttribute($intern_21), content;
      if (name) {
        name = name.replace($intern_22, $intern_23);
        if (name.indexOf($intern_24) >= 0) {
          continue;
        }
        if (name == $intern_25) {
          content = meta.getAttribute($intern_26);
          if (content) {
            var value, eq = content.indexOf($intern_27);
            if (eq >= 0) {
              name = content.substring(0, eq);
              value = content.substring(eq + 1);
            }
             else {
              name = content;
              value = $intern_23;
            }
            metaProps[name] = value;
          }
        }
         else if (name == $intern_28) {
          content = meta.getAttribute($intern_26);
          if (content) {
            try {
              propertyErrorFunc = eval(content);
            }
             catch (e) {
              alert($intern_29 + content + $intern_30);
            }
          }
        }
         else if (name == $intern_31) {
          content = meta.getAttribute($intern_26);
          if (content) {
            try {
              onLoadErrorFunc = eval(content);
            }
             catch (e) {
              alert($intern_29 + content + $intern_32);
            }
          }
        }
      }
    }
    __gwt_getMetaProperty = function(name){
      var value = metaProps[name];
      return value == null?null:value;
    }
    ;
    __propertyErrorFunction = propertyErrorFunc;
    showcase.__errFn = onLoadErrorFunc;
  }

  function computeScriptBase(){
    function getDirectoryOfFile(path){
      var hashIndex = path.lastIndexOf($intern_33);
      if (hashIndex == -1) {
        hashIndex = path.length;
      }
      var queryIndex = path.indexOf($intern_34);
      if (queryIndex == -1) {
        queryIndex = path.length;
      }
      var slashIndex = path.lastIndexOf($intern_35, Math.min(queryIndex, hashIndex));
      return slashIndex >= 0?path.substring(0, slashIndex + 1):$intern_23;
    }

    function ensureAbsoluteUrl(url){
      if (url.match(/^\w+:\/\//)) {
      }
       else {
        var img = $doc.createElement($intern_36);
        img.src = url + $intern_37;
        url = getDirectoryOfFile(img.src);
      }
      return url;
    }

    function tryMetaTag(){
      var metaVal = __gwt_getMetaProperty($intern_38);
      if (metaVal != null) {
        return metaVal;
      }
      return $intern_23;
    }

    function tryNocacheJsTag(){
      var scriptTags = $doc.getElementsByTagName($intern_12);
      for (var i = 0; i < scriptTags.length; ++i) {
        if (scriptTags[i].src.indexOf($intern_39) != -1) {
          return getDirectoryOfFile(scriptTags[i].src);
        }
      }
      return $intern_23;
    }

    function tryBaseTag(){
      var baseElements = $doc.getElementsByTagName($intern_40);
      if (baseElements.length > 0) {
        return baseElements[baseElements.length - 1].href;
      }
      return $intern_23;
    }

    var tempBase = tryMetaTag();
    if (tempBase == $intern_23) {
      tempBase = tryNocacheJsTag();
    }
    if (tempBase == $intern_23) {
      tempBase = tryBaseTag();
    }
    if (tempBase == $intern_23) {
      tempBase = getDirectoryOfFile($doc.location.href);
    }
    tempBase = ensureAbsoluteUrl(tempBase);
    return tempBase;
  }

  function computeUrlForResource(resource){
    if (resource.match(/^\//)) {
      return resource;
    }
    if (resource.match(/^[a-zA-Z]+:\/\//)) {
      return resource;
    }
    return showcase.__moduleBase + resource;
  }

  function getCompiledCodeFilename(){
    var answers = [];
    var softPermutationId;
    function unflattenKeylistIntoAnswers(propValArray, value){
      var answer = answers;
      for (var i = 0, n = propValArray.length - 1; i < n; ++i) {
        answer = answer[propValArray[i]] || (answer[propValArray[i]] = []);
      }
      answer[propValArray[n]] = value;
    }

    var values = [];
    var providers = [];
    function computePropValue(propName){
      var value = providers[propName](), allowedValuesMap = values[propName];
      if (value in allowedValuesMap) {
        return value;
      }
      var allowedValuesList = [];
      for (var k in allowedValuesMap) {
        allowedValuesList[allowedValuesMap[k]] = k;
      }
      if (__propertyErrorFunc) {
        __propertyErrorFunc(propName, allowedValuesList, value);
      }
      throw null;
    }

    providers[$intern_41] = function(){
      {
        var mgwt_os = function(){
          var ua = window.navigator.userAgent.toLowerCase();
          if (ua.indexOf($intern_42) != -1) {
            if (ua.indexOf($intern_43) != -1) {
              return $intern_42;
            }
             else {
              return $intern_44;
            }
          }
          if (ua.indexOf($intern_45) != -1) {
            return $intern_45;
          }
          if (ua.indexOf($intern_46) != -1) {
            if (window.devicePixelRatio >= 2) {
              return $intern_47;
            }
            return $intern_46;
          }
          if (ua.indexOf($intern_48) != -1) {
            return $intern_48;
          }
          return $intern_49;
        }
        ();
        return mgwt_os;
      }
    }
    ;
    values[$intern_41] = {android:0, android_tablet:1, blackberry:2, desktop:3, ipad:4, iphone:5, retina:6};
    providers[$intern_50] = function(){
      {
        var user_agent = function(){
          var ua = window.navigator.userAgent.toLowerCase();
          if (ua.indexOf($intern_42) != -1) {
            return $intern_51;
          }
          if (ua.indexOf($intern_46) != -1) {
            return $intern_51;
          }
          if (ua.indexOf($intern_45) != -1) {
            return $intern_51;
          }
          if (ua.indexOf($intern_48) != -1) {
            return $intern_52;
          }
          return $intern_52;
        }
        ();
        return user_agent;
      }
    }
    ;
    values[$intern_50] = {mobilesafari:0, not_mobile:1};
    providers[$intern_53] = function(){
      {
        var ua = window.navigator.userAgent.toLowerCase();
        if (ua.indexOf($intern_42) != -1 || (ua.indexOf($intern_45) != -1 || (ua.indexOf($intern_46) != -1 || ua.indexOf($intern_48) != -1))) {
          var url = document.location.href;
          if (url.indexOf($intern_54) === 0) {
            return $intern_55;
          }
        }
        return $intern_56;
      }
    }
    ;
    values[$intern_53] = {no:0, yes:1};
    __gwt_isKnownPropertyValue = function(propName, propValue){
      return propValue in values[propName];
    }
    ;
    showcase.__computePropValue = computePropValue;
    sendStats($intern_0, $intern_57);
    if (isHostedMode()) {
      return computeUrlForResource($intern_58);
    }
    var strongName;
    try {
      unflattenKeylistIntoAnswers([$intern_48, $intern_52, $intern_55], $intern_59);
      unflattenKeylistIntoAnswers([$intern_48, $intern_52, $intern_56], $intern_60);
      unflattenKeylistIntoAnswers([$intern_44, $intern_51, $intern_55], $intern_61);
      unflattenKeylistIntoAnswers([$intern_46, $intern_52, $intern_56], $intern_62);
      unflattenKeylistIntoAnswers([$intern_44, $intern_51, $intern_56], $intern_63);
      unflattenKeylistIntoAnswers([$intern_49, $intern_51, $intern_55], $intern_64);
      unflattenKeylistIntoAnswers([$intern_45, $intern_51, $intern_56], $intern_65);
      unflattenKeylistIntoAnswers([$intern_47, $intern_52, $intern_55], $intern_66);
      unflattenKeylistIntoAnswers([$intern_47, $intern_51, $intern_55], $intern_67);
      unflattenKeylistIntoAnswers([$intern_48, $intern_51, $intern_55], $intern_68);
      unflattenKeylistIntoAnswers([$intern_46, $intern_51, $intern_56], $intern_69);
      unflattenKeylistIntoAnswers([$intern_49, $intern_52, $intern_55], $intern_70);
      unflattenKeylistIntoAnswers([$intern_47, $intern_51, $intern_56], $intern_71);
      unflattenKeylistIntoAnswers([$intern_42, $intern_51, $intern_56], $intern_72);
      unflattenKeylistIntoAnswers([$intern_45, $intern_51, $intern_55], $intern_73);
      unflattenKeylistIntoAnswers([$intern_49, $intern_51, $intern_56], $intern_74);
      unflattenKeylistIntoAnswers([$intern_46, $intern_52, $intern_55], $intern_75);
      unflattenKeylistIntoAnswers([$intern_42, $intern_52, $intern_55], $intern_76);
      unflattenKeylistIntoAnswers([$intern_49, $intern_52, $intern_56], $intern_77);
      unflattenKeylistIntoAnswers([$intern_42, $intern_51, $intern_55], $intern_78);
      unflattenKeylistIntoAnswers([$intern_46, $intern_51, $intern_55], $intern_79);
      unflattenKeylistIntoAnswers([$intern_47, $intern_52, $intern_56], $intern_80);
      unflattenKeylistIntoAnswers([$intern_45, $intern_52, $intern_55], $intern_81);
      unflattenKeylistIntoAnswers([$intern_42, $intern_52, $intern_56], $intern_82);
      unflattenKeylistIntoAnswers([$intern_44, $intern_52, $intern_55], $intern_83);
      unflattenKeylistIntoAnswers([$intern_48, $intern_51, $intern_56], $intern_84);
      unflattenKeylistIntoAnswers([$intern_45, $intern_52, $intern_56], $intern_85);
      unflattenKeylistIntoAnswers([$intern_44, $intern_52, $intern_56], $intern_86);
      strongName = answers[computePropValue($intern_41)][computePropValue($intern_50)][computePropValue($intern_53)];
      var idx = strongName.indexOf($intern_87);
      if (idx != -1) {
        softPermutationId = strongName.substring(idx + 1);
        strongName = strongName.substring(0, idx);
      }
    }
     catch (e) {
    }
    showcase.__softPermutationId = softPermutationId;
    return computeUrlForResource(strongName + $intern_88);
  }

  function loadExternalStylesheets(){
    if (!$wnd.__gwt_stylesLoaded) {
      $wnd.__gwt_stylesLoaded = {};
    }
    sendStats($intern_89, $intern_1);
    sendStats($intern_89, $intern_90);
  }

  processMetas();
  showcase.__moduleBase = computeScriptBase();
  var filename = getCompiledCodeFilename();
  loadExternalStylesheets();
  sendStats($intern_0, $intern_90);
  installScript(filename);
}

showcase();
