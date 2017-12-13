echo "inizio elaborazione"
set classpath=".;C:\Java\Jcraft\jsch-0.1.51\jsch-0.1.51.jar"
set dir=/app/bea/user_projects/domains/granite8_1/di_logs
set outdir=C:\\Temp\\din-logs\\esercizio
set server=dineseas
set file=GenericWorkItemHandler.log
echo "Classpath: " %classpath%
echo "..................."
java -classpath %classpath% Sftp 10.38.38.132 bea beabea %outdir% %file% %dir% %server%1
java -classpath %classpath% Sftp 10.38.38.133 bea beabea %outdir% %file% %dir% %server%2
java -classpath %classpath% Sftp 10.38.38.134 bea beabea %outdir% %file% %dir% %server%3
java -classpath %classpath% Sftp 10.38.38.135 bea beabea %outdir% %file% %dir% %server%4
java -classpath %classpath% Sftp 10.38.38.136 bea beabea %outdir% %file% %dir% %server%5
java -classpath %classpath% Sftp 10.38.38.137 bea beabea %outdir% %file% %dir% %server%6
echo "..................."