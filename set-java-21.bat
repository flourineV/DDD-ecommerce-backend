@echo off
echo Setting JAVA_HOME to Java 21...

REM Common Java 21 installation paths
set JAVA21_PATHS=C:\Program Files\Java\jdk-21;C:\Program Files\Eclipse Adoptium\jdk-21;C:\Program Files\Microsoft\jdk-21;C:\Program Files\Amazon Corretto\jdk21

for %%p in (%JAVA21_PATHS%) do (
    if exist "%%p" (
        set JAVA_HOME=%%p
        echo JAVA_HOME set to: %%p
        goto :found
    )
)

echo Java 21 not found in common paths. Please set JAVA_HOME manually.
echo Example: set JAVA_HOME=C:\Path\To\Your\Java21
goto :end

:found
set PATH=%JAVA_HOME%\bin;%PATH%
echo.
echo Java version:
java -version

:end
