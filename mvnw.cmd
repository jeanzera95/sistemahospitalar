@echo off
setlocal
set CMD_LINE_ARGS=
:loop
if "%1"=="" goto end
set CMD_LINE_ARGS=%CMD_LINE_ARGS% %1
shift
goto loop
:end
mvn %CMD_LINE_ARGS%