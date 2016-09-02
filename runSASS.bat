
@echo off

echo "Converting .scss to .css"
echo "-------------------------"
echo.

for %%f in (css/sass/*.scss) do (
  call echo "css/sass/%%f > css/%%~nf.css"
  call sass --trace --sourcemap=none --no-cache --style=expanded css/sass/%%f css/%%~nf.css
)

echo.
echo "-------------------------"
echo "Done - Hit any key to quit"
echo.
pause
