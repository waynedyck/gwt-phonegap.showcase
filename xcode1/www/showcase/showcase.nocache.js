function showcase(){
  var $intern_23 = '', $intern_32 = '" for "gwt:onLoadErrorFn"', $intern_30 = '" for "gwt:onPropertyErrorFn"', $intern_33 = '#', $intern_94 = '.cache.js', $intern_35 = '/', $intern_61 = '0DA001B70F209DD8AC70A6FCCD5C88CA', $intern_62 = '14EB4FAAB8979B37D024EF73E17869EC', $intern_63 = '1B335DFB0C13332FCAC225F0E5772E81', $intern_64 = '26865D7E93C1020B02F2B165F4B16AF9', $intern_65 = '2B4EF17C20F7AD10EC7C89021D9731D5', $intern_66 = '37D37645A35DFE4D22164E4E78A71173', $intern_67 = '3B41AFA9918A75C7E85DBE3357258BFD', $intern_68 = '4042281BEB3AB2D74C158B5F22333031', $intern_69 = '45644BDE3F8A737A49DCC0301F145FAD', $intern_70 = '56E91B85966DA293A62362D69F4C3D04', $intern_71 = '585BD750133FB022F47375E8D3155AC6', $intern_72 = '58980EBF33C0410B8705A756534003D1', $intern_73 = '62BCDA6EFFDBEF23187418208D79C3D5', $intern_74 = '680AD2777846308D8D96A2878E4D85F4', $intern_75 = '6C03D096B33925D7A3F40A215ED04585', $intern_76 = '732EED346B5574563549D8EBC0E66B81', $intern_77 = '7BACD60703812407B4A93E23D068F784', $intern_78 = '7D8F75713C489617025F8B8F5BA1BA58', $intern_79 = '8EF8688BB8C78AA8BA8AD87EA283718E', $intern_80 = '94A0518E89EDF69B943248EBB05A2820', $intern_93 = ':', $intern_24 = '::', $intern_11 = '<html><head><\/head><body><\/body><\/html>', $intern_27 = '=', $intern_34 = '?', $intern_81 = 'AB05C3EF7A9F57AD91A3278DAD75BD46', $intern_82 = 'B891263B669B9E33424A108D97DEFE72', $intern_83 = 'BA7AEF53249E4F150184F1001CA9FD90', $intern_84 = 'BBBBE1C480268B2B5D571FBF6BC6170B', $intern_29 = 'Bad handler "', $intern_85 = 'C03A969008BF1371C2C212F99017AE06', $intern_86 = 'C22FCDD05E2E9F492D5E41AF7D13B73E', $intern_87 = 'CA8158E0D6B920BC4A974DC372B8ED71', $intern_88 = 'DB4B784E216B65D9995F1E53FC1C69AE', $intern_89 = 'DF0A150279B554765016761DA538EDAC', $intern_16 = 'DOMContentLoaded', $intern_6 = 'DUMMY', $intern_90 = 'E78C6FB0507B9080F690D5F416F79A5C', $intern_91 = 'F880662C5EA581DD85BE30CAFB931662', $intern_92 = 'FA06B1156F0976E2E5D562E468163BC1', $intern_42 = 'android', $intern_44 = 'android_tablet', $intern_40 = 'base', $intern_38 = 'baseUrl', $intern_1 = 'begin', $intern_50 = 'blackberry', $intern_7 = 'body', $intern_0 = 'bootstrap', $intern_37 = 'clear.cache.gif', $intern_26 = 'content', $intern_51 = 'desktop', $intern_96 = 'end', $intern_56 = 'file://', $intern_2 = 'gwt.codesvr.showcase=', $intern_3 = 'gwt.codesvr=', $intern_31 = 'gwt:onLoadErrorFn', $intern_28 = 'gwt:onPropertyErrorFn', $intern_25 = 'gwt:property', $intern_19 = 'head', $intern_8 = 'iframe', $intern_36 = 'img', $intern_45 = 'ipad', $intern_46 = 'ipad_retina', $intern_47 = 'iphone', $intern_48 = 'ipod', $intern_13 = 'javascript', $intern_9 = 'javascript:""', $intern_95 = 'loadExternalRefs', $intern_20 = 'meta', $intern_41 = 'mgwt.os', $intern_43 = 'mobile', $intern_52 = 'mobile.user.agent', $intern_53 = 'mobilesafari', $intern_18 = 'moduleRequested', $intern_17 = 'moduleStartup', $intern_21 = 'name', $intern_58 = 'no', $intern_54 = 'not_mobile', $intern_55 = 'phonegap.env', $intern_10 = 'position:absolute; width:0; height:0; border:none; left: -1000px; top: -1000px; !important', $intern_49 = 'retina', $intern_12 = 'script', $intern_59 = 'selectingPermutation', $intern_4 = 'showcase', $intern_60 = 'showcase.devmode.js', $intern_39 = 'showcase.nocache.js', $intern_22 = 'showcase::', $intern_5 = 'startup', $intern_15 = 'undefined', $intern_14 = 'var $wnd = window.parent;', $intern_57 = 'yes';
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
            if (window.devicePixelRatio >= 2) {
              return $intern_46;
            }
            return $intern_45;
          }
          if (ua.indexOf($intern_47) != -1 || ua.indexOf($intern_48) != -1) {
            if (window.devicePixelRatio >= 2) {
              return $intern_49;
            }
            return $intern_47;
          }
          if (ua.indexOf($intern_50) != -1) {
            return $intern_50;
          }
          return $intern_51;
        }
        ();
        return mgwt_os;
      }
    }
    ;
    values[$intern_41] = {android:0, android_tablet:1, blackberry:2, desktop:3, ipad:4, ipad_retina:5, iphone:6, retina:7};
    providers[$intern_52] = function(){
      {
        var user_agent = function(){
          var ua = window.navigator.userAgent.toLowerCase();
          if (ua.indexOf($intern_42) != -1) {
            return $intern_53;
          }
          if (ua.indexOf($intern_47) != -1) {
            return $intern_53;
          }
          if (ua.indexOf($intern_48) != -1) {
            return $intern_53;
          }
          if (ua.indexOf($intern_45) != -1) {
            return $intern_53;
          }
          if (ua.indexOf($intern_50) != -1) {
            return $intern_54;
          }
          return $intern_54;
        }
        ();
        return user_agent;
      }
    }
    ;
    values[$intern_52] = {mobilesafari:0, not_mobile:1};
    providers[$intern_55] = function(){
      {
        var ua = window.navigator.userAgent.toLowerCase();
        if (ua.indexOf($intern_42) != -1 || (ua.indexOf($intern_45) != -1 || (ua.indexOf($intern_48) != -1 || (ua.indexOf($intern_47) != -1 || ua.indexOf($intern_50) != -1)))) {
          var url = document.location.href;
          if (url.indexOf($intern_56) === 0) {
            return $intern_57;
          }
        }
        return $intern_58;
      }
    }
    ;
    values[$intern_55] = {no:0, yes:1};
    __gwt_isKnownPropertyValue = function(propName, propValue){
      return propValue in values[propName];
    }
    ;
    showcase.__computePropValue = computePropValue;
    sendStats($intern_0, $intern_59);
    if (isHostedMode()) {
      return computeUrlForResource($intern_60);
    }
    var strongName;
    try {
      unflattenKeylistIntoAnswers([$intern_44, $intern_53, $intern_58], $intern_61);
      unflattenKeylistIntoAnswers([$intern_44, $intern_53, $intern_57], $intern_62);
      unflattenKeylistIntoAnswers([$intern_50, $intern_54, $intern_57], $intern_63);
      unflattenKeylistIntoAnswers([$intern_50, $intern_54, $intern_58], $intern_64);
      unflattenKeylistIntoAnswers([$intern_46, $intern_54, $intern_58], $intern_65);
      unflattenKeylistIntoAnswers([$intern_46, $intern_53, $intern_57], $intern_66);
      unflattenKeylistIntoAnswers([$intern_49, $intern_54, $intern_57], $intern_67);
      unflattenKeylistIntoAnswers([$intern_42, $intern_53, $intern_58], $intern_68);
      unflattenKeylistIntoAnswers([$intern_50, $intern_53, $intern_57], $intern_69);
      unflattenKeylistIntoAnswers([$intern_45, $intern_53, $intern_57], $intern_70);
      unflattenKeylistIntoAnswers([$intern_45, $intern_54, $intern_58], $intern_71);
      unflattenKeylistIntoAnswers([$intern_42, $intern_54, $intern_57], $intern_72);
      unflattenKeylistIntoAnswers([$intern_49, $intern_54, $intern_58], $intern_73);
      unflattenKeylistIntoAnswers([$intern_51, $intern_54, $intern_57], $intern_74);
      unflattenKeylistIntoAnswers([$intern_42, $intern_54, $intern_58], $intern_75);
      unflattenKeylistIntoAnswers([$intern_47, $intern_54, $intern_58], $intern_76);
      unflattenKeylistIntoAnswers([$intern_45, $intern_53, $intern_58], $intern_77);
      unflattenKeylistIntoAnswers([$intern_44, $intern_54, $intern_58], $intern_78);
      unflattenKeylistIntoAnswers([$intern_47, $intern_54, $intern_57], $intern_79);
      unflattenKeylistIntoAnswers([$intern_42, $intern_53, $intern_57], $intern_80);
      unflattenKeylistIntoAnswers([$intern_49, $intern_53, $intern_58], $intern_81);
      unflattenKeylistIntoAnswers([$intern_46, $intern_53, $intern_58], $intern_82);
      unflattenKeylistIntoAnswers([$intern_51, $intern_53, $intern_57], $intern_83);
      unflattenKeylistIntoAnswers([$intern_47, $intern_53, $intern_58], $intern_84);
      unflattenKeylistIntoAnswers([$intern_46, $intern_54, $intern_57], $intern_85);
      unflattenKeylistIntoAnswers([$intern_47, $intern_53, $intern_57], $intern_86);
      unflattenKeylistIntoAnswers([$intern_51, $intern_53, $intern_58], $intern_87);
      unflattenKeylistIntoAnswers([$intern_45, $intern_54, $intern_57], $intern_88);
      unflattenKeylistIntoAnswers([$intern_51, $intern_54, $intern_58], $intern_89);
      unflattenKeylistIntoAnswers([$intern_50, $intern_53, $intern_58], $intern_90);
      unflattenKeylistIntoAnswers([$intern_44, $intern_54, $intern_57], $intern_91);
      unflattenKeylistIntoAnswers([$intern_49, $intern_53, $intern_57], $intern_92);
      strongName = answers[computePropValue($intern_41)][computePropValue($intern_52)][computePropValue($intern_55)];
      var idx = strongName.indexOf($intern_93);
      if (idx != -1) {
        softPermutationId = strongName.substring(idx + 1);
        strongName = strongName.substring(0, idx);
      }
    }
     catch (e) {
    }
    showcase.__softPermutationId = softPermutationId;
    return computeUrlForResource(strongName + $intern_94);
  }

  function loadExternalStylesheets(){
    if (!$wnd.__gwt_stylesLoaded) {
      $wnd.__gwt_stylesLoaded = {};
    }
    sendStats($intern_95, $intern_1);
    sendStats($intern_95, $intern_96);
  }

  processMetas();
  showcase.__moduleBase = computeScriptBase();
  var filename = getCompiledCodeFilename();
  loadExternalStylesheets();
  sendStats($intern_0, $intern_96);
  installScript(filename);
}

showcase();
