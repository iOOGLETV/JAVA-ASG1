/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package atm;

import atm.Accounts;

/**
 *
 * @author omsf7f
 */
public class Checking extends Accounts
{
     
    public Checking(double begin_balance)
    {
        balance = begin_balance;
    }
}