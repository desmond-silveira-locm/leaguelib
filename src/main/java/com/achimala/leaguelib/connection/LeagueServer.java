/*
 *  This file is part of LeagueLib.
 *  LeagueLib is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  LeagueLib is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with LeagueLib.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.achimala.leaguelib.connection;

import java.util.HashMap;
import java.util.Map;

public enum LeagueServer {
    NORTH_AMERICA("NA", "North America"),
    EUROPE_WEST("EUW", "Europe West"),
    EUROPE_NORDIC_AND_EAST("EUNE", "Europe Nordic & East"),
    BRAZIL("BR", "Brazil"),
    KOREA("KR", "Korea"),
    LATIN_AMERICA_NORTH("LAN", "Latin America North"),
    LATIN_AMERICA_SOUTH("LAS", "Latin America South"),
    OCEANIA("OCE", "Oceania"),
    RUSSIA("RU", "Russia"),
    TURKEY("TR","Turkey");
    // Garena servers...
    // PublicBetaEnvironment

    private static final Map<String, LeagueServer> stringToEnum = new HashMap<>();
    static {
        for (LeagueServer leagueServer : values()) {
            stringToEnum.put(leagueServer._serverCode, leagueServer);
        }
    }

    private String _serverCode, _publicName;

    private LeagueServer(String serverCode, String publicName) {
        _serverCode = serverCode;
        _publicName = publicName;
    }

    public static LeagueServer findServerByCode(String code) {
        for(LeagueServer server : LeagueServer.values())
            if(server.getServerCode().equalsIgnoreCase(code))
                return server;
        return null;
    }

    public String getServerCode() {
        return _serverCode;
    }

    public String getPublicName() {
        return _publicName;
    }

    @Override
    public String toString() {
        return "<LeagueServer:" + _publicName + " (" + _serverCode + ")>";
    }

    public static LeagueServer fromString(String str) {
        if (str == null) {
            return null;
        }
        return stringToEnum.get(str.toUpperCase());
    }
}