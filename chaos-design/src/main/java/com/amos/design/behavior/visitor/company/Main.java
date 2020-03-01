package com.amos.design.behavior.visitor.company;

/**
 * DESCRIPTION: Main
 *
 * @author <a href="mailto:amos.wang@xiaoi.com">amos.wang</a>
 * @date 3/1/2020
 */
public class Main {

    public static void main(String[] args) {
        CompanyPersonStruct struct = new CompanyPersonStruct();
        struct.addPerson(new CompanyPersonDeveloper("dev-01"));
        struct.addPerson(new CompanyPersonDeveloper("dev-02"));
        struct.addPerson(new CompanyPersonDeveloper("dev-03"));
        struct.addPerson(new CompanyPersonManager("mgr-01"));
        struct.addPerson(new CompanyPersonManager("mgr-02"));
        struct.addPerson(new CompanyPersonManager("mgr-03"));

        struct.range(new CeoVisitor());
        System.out.println();
        struct.range(new CtoVisitor());
    }

}
