var linkGit = "https://github.com/Kazeheki";
var linkDocu = "docu/index.html";

function goToHome(){
  $(".content").fadeOut("slow", function(){
    $(".contentInner").load("mainContent.html", function(){
      $(".content").fadeIn("slow");
    });
  });

  $(".menuBtn").removeClass("open");
  $(".menuList").slideUp(600);
};

function goToGit(){
  location.href = linkGit;
};

function goToScreenshots(){
  $(".content").fadeOut("slow", function(){
    $(".contentInner").load("screenshots.html", function(){
      $(".content").fadeIn("slow");
    });
  });

  $(".menuBtn").removeClass("open");
  $(".menuList").slideUp(600);
};

function goToDocu(){
  location.href = linkDocu;
};
