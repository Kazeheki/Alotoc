function setToTopBtn(){
  var htmlBody = $("html, body");
  var btn = $(".toTop");
  var visible = btn.is(":visible");
  if(htmlBody.scrollTop() >= 10){
    if(visible == false){
      btn.fadeIn(200);
    }
  }else{
    if(visible){
      btn.fadeOut(200);
    }
  }
};

function goToTop(){
  $("html, body").animate({scrollTop: 0}, 600);
};

function isMobile(){
  return /Android|webOS|iPhone|iPad|iPod|BlackBerry|BB|PlayBook|IEMobile|Windows Phone|Kindle|Silk|Opera Mini/i.test(navigator.userAgent);
};

function setContentSize(){
  $(".contentInner").css("font-size", "20px");
  $(".mainContent").css("width", "55%");
  var size = $(".contentInner").css("font-size");
  if(isMobile()){
    $(".contentInner").css("font-size", "30px");
    $(".mainContent").css("width", "70%");
  }
};

function resizeMethods(){
  setMenu();
  setContentSize();
};

var main = function(){
  /*setTimeout(function(){
    $(".loader").fadeOut(200, function(){
      $(".loader").remove();
    });
  }, 2000);*/
  $(".loader").remove();
  $(".content").hide();
  $(".contentInner").load("mainContent.html", function(){
    $(".content").fadeIn("slow");
  });

  setMenuBtnToFixedSize();

  $("#alotoc").addClass("unselectable");
  $(".menuBtn").hide();
  $(".menuList").hide();

  $(".hoverable").hover(function(){
    $(this).toggleClass("hoverOver");
  });

  $(".menu").addClass("unselectable");
  $(".menuList").addClass("unselectable");

  resizeMethods();
  $(window).on("resize", resizeMethods);
  $(document).on("resize", resizeMethods);

  $(".toTop").hide();
  $(document).on("scroll", setToTopBtn);
};

$(document).ready(main);
