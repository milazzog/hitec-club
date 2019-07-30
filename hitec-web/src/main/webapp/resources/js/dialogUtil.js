/**
 * Created by GiuseppeMilazzo on 30/07/2019.
 */
var DialogUtil = {
    hideDialog: function (name, xhr, status, args) {
        if (!args.validationFailed && !args.isError) {
            PF(name).hide();
        }
    }
};