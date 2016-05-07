package com.bkhaled.squidws.client.proxy;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import com.bkhaled.squidws.client.modal.Profile;
import com.bkhaled.squidws.client.modal.User;
import com.bkhaled.squidws.client.services.ProfileService;

public class SquidConfigManager {

    ProfileService profileService = new ProfileService();
    SquidAclManager aclBuilder = new SquidAclManager();

    static String SQUID_PATH = "/etc/squid3/squid.conf";
    static String SQUID_PATH2 = "/etc/squid/squid.conf";
    static String IPTABLE_PATH = "";
    static String RECONF_SQUID_CMD = "";

    public void connectUser(User user) {
        System.out.println("com.bkhaled.squidws.client.proxy.SquidConfigManager.connectUser()");
        // TODO Auto-generated method stub
        List<Profile> profiles = profileService.getProfiles(user.getId());
        String acl = aclBuilder.createAcl(profiles, user);
        WriteToIptable(user.getIpAdress());
        WriteToConfigFile(acl, 15); // LINE NUMBER GET FROM aclBuilder - replace
        // 5. 5 for test only
        ReconfigureSquid(RECONF_SQUID_CMD);

    }

    private void WriteToIptable(String ip) {
        // CODE TO UPDATE IPTABLE
    }

    private void WriteToConfigFile(String command, int lineNumber) {
        // CODE WRITE CHANGES TO SQUID.CONF
        System.out.println("com.bkhaled.squidws.client.proxy.SquidConfigManager.WriteToConfigFile()");
        Path path = Paths.get(SQUID_PATH);
        if (path.toFile().exists()) {
            List<String> lines;
            try {
                lines = Files.readAllLines(path, StandardCharsets.UTF_8);
                lines.set(lineNumber - 1, System.getProperty("user.home"));
                lines.set(lineNumber, "TESTING ACL HERE2");
                lines.set(lineNumber + 1, "TESTING ACL HERE2");
                Files.write(path, lines, StandardCharsets.UTF_8);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } else {
            Path path2 = Paths.get(SQUID_PATH2);
            List<String> lines;
            try {
                lines = Files.readAllLines(path2, StandardCharsets.UTF_8);
                lines.set(lineNumber - 1, System.getProperty("user.home"));
                lines.set(lineNumber, "TESTING ACL HERE2");
                lines.set(lineNumber + 1, "TESTING ACL HERE2");
                Files.write(path2, lines, StandardCharsets.UTF_8);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        /*
		 * try(PrintWriter out = new PrintWriter(new BufferedWriter(new
		 * FileWriter(SQUID_PATH, true)))) { out.println(
		 * "acl blockSite dstdomain www.bing.com"); //more code out.println(
		 * "http_access deny blockSite"); //more code System.out.println(
		 * "WRITING ACL TO SQUID.CONF...done!"); }catch (IOException e) {
		 * //exception handling left as an exercise for the reader
		 * e.printStackTrace(); }
         */
    }

    private void ReconfigureSquid(String command) {
        // CODE TO RUN IN BASH (squid -k reconfigure) OR (service squid restart)
    }

}
