if type -p java; then
    echo found java executable in PATH, running program.
elif [[ -n "$JAVA_HOME" ]] && [[ -x "$JAVA_HOME/bin/java" ]];  then
    echo found java executable in JAVA_HOME
else
    echo "No java found. Please install JRE and add it to either PATH or JAVA_HOME"
    exit 1
fi

java -jar ./citymapper.jar "$@"