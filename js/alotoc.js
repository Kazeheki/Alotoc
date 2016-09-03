
function setContentSize(){
  var size = $(".contentInner").css("font-size");
  if(size < "20px"){
    $(".contentInner").css("font-size", "20px");
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
