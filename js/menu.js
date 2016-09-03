
function setMenuBtnToFixedSize(){
  //set btn to fixed size.
  var btnW = $(".menuBtn").width();
  var btnH = $(".menuBtn").height();
  $(".menuBtn").css("min-width", btnW);
  $(".menuBtn").css("max-width", btnW);
  $(".menuBtn").css("min-height", btnH);
  $(".menuBtn").css("max-height", btnH);
};

function setMenuTableMargin(){
  var m = ($(window).width() - $(".menuTable").width()) / 2;

  $(".menuTable").css("margin-left", m);
};

function setBannerMargin(){
  var m = ($(window).width() - $("#alotoc").innerWidth()) / 2;

  $(".banner > div").css("margin-left", m);
};

function setBannerSize(){
  $(".banner > span").css("font-size", "20vw");
  var size = $(".banner > span").css("font-size");
  if(size > "150px"){
    $(".banner > span").css("font-size", "150px");
  }
};

function setMenu(){
  setBannerSize();
  var minWidth = $(".menuTable").outerWidth();
  if($(window).width() < minWidth){
    $(".menuBtn").removeClass("open");
    $(".menuBtn").show();
    $(".menuTable").hide();
    $(".menuList").slideUp(600);
  }else{
    $(".menuTable").show();
    $(".menuList").hide();
    $(".menuBtn").hide();
    setMenuTableMargin();
  }
  setBannerMargin();
};

//-----Click-Methods-----
//if clicked anywhere, close menu.
$(document.body).on("click", function(){
  $(".menuList").slideUp(600);
  $(".menuBtn").removeClass("open");
});

//if clicked on list, hinder invocation of function above.
$(".menuList").on("click", function(event){
  event.stopPropagation();
});

//if clicked on menu btn, hinder invocation of funtion above.
//also, open list or close it.
$(".menuBtn").on("click", function(event){
  var l = $(".menuList");
  var btn = $(".menuBtn");

  event.stopPropagation();

  if(l.is(":hidden")){
    btn.addClass("open");
    l.slideDown(600);
  }else{
    btn.removeClass("open");
    l.slideUp(600);
  }
});
