paypal.use( ['login'], function (login) {
  login.render ({
    "appid":"Aa72oWefXrHyn761ApdLqPLYJpraE5TIo4B3bAvLXyMoh8wVaOPgmipxUBvL91DMOpgcMpgCmhuMsWHl",
    "authend":"sandbox",
    "scopes":"openid",
    "containerid":"cwppButton",
    "responseType":"code",
    "locale":"fr-fr",
    "buttonShape":"pill",
    "buttonSize":"lg",
    "fullPage":"true",
    "returnurl":"https://www.google.com/"
  });
});