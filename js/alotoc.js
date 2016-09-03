
var main = function(){
  $(".content").hide();
  $(".contentInner").load("mainContent.html", function(){
    $(".content").fadeIn("slow");
  });
  //set btn to fixed size.
  var btnW = $(".menuBtn").width();
  var btnH = $(".menuBtn").height();
  $(".menuBtn").css("min-width", btnW);
  $(".menuBtn").css("max-width", btnW);
  $(".menuBtn").css("min-height", btnH);
  $(".menuBtn").css("max-height", btnH);

  $("#alotoc").addClass("unselectable");
  $(".menuBtn").hide();
  $(".menuList").hide();

  $(".hoverable").hover(function(){
    $(this).toggleClass("hoverOver");
  });

  $(".menu").addClass("unselectable");
  $(".menuList").addClass("unselectable");

  setMenu();
  $(window).on("resize", setMenu);
  $(document).on("resize", setMenu);
};

$(document).ready(main);
