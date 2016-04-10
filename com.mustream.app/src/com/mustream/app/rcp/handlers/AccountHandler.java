package com.mustream.app.rcp.handlers;

import com.mustream.app.rcp.parts.LeftPart;
import org.eclipse.e4.core.di.annotations.Execute;

public class AccountHandler
{
  @Execute
  public void execute()
  {
    LeftPart leftManageAccountHandler = new LeftPart();
    leftManageAccountHandler.showNowSettingsPart();
  }
}
