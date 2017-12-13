echo "inizio elaborazione"
set classpath=".;C:\Java\Jcraft\jsch-0.1.51\jsch-0.1.51.jar"
set dir=/app/bea/user_projects/domains/granite_92/di_logs
set outdir=C:\\Temp\\din-logs\\esercizio
set server=dineseas-92
set file=servicesDin.log
echo "Classpath: " %classpath%
echo "..................."
java -classpath %classpath% Sftp 10.38.39.8 bea beabea %outdir% %file% %dir% %server%1
java -classpath %classpath% Sftp 10.38.39.8 bea beabea %outdir% %file%.1 %dir% %server%1
java -classpath %classpath% Sftp 10.38.39.8 bea beabea %outdir% %file%.2 %dir% %server%1
java -classpath %classpath% Sftp 10.38.39.9 bea beabea %outdir% %file% %dir% %server%2
java -classpath %classpath% Sftp 10.38.39.9 bea beabea %outdir% %file%.1 %dir% %server%2
java -classpath %classpath% Sftp 10.38.39.9 bea beabea %outdir% %file%.2 %dir% %server%2
echo "..................."