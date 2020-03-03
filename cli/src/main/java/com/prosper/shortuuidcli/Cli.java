package com.prosper.shortuuidcli;

import com.hsingh.shortuuid.ShortUuid;

/**
 * A CLI application which will output a newly generated {@link ShortUuid} to stdout
 *
 * @author Don Phillips
 */
public class Cli {

    public static void main(String[] args) {
        System.out.print(new ShortUuid.Builder().build());
    }
}
