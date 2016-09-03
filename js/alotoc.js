
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

  setMenu();
  $(window).on("resize", setMenu);
  $(document).on("resize", setMenu);
};

$(document).ready(main);
