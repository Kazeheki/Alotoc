function isMobile(){
  return /Android|webOS|iPhone|iPad|iPod|BlackBerry|BB|PlayBook|IEMobile|Windows Phone|Kindle|Silk|Opera Mini/i.test(navigator.userAgent);
};

function setContentSize(){
  $(".contentInner").css("font-size", "20px");
  var size = $(".contentInner").css("font-size");
  if(isMobile()){
    $(".contentInner").css("font-size", "30px");
  }
};

function resizeMethods(){
  setMenu();
  setContentSize();
};

var main = function(){
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
};

$(document).ready(main);
